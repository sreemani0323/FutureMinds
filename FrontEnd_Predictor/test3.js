document.getElementById("predictForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const resultsDiv = document.getElementById("results");
    resultsDiv.innerHTML = "<p>Loading colleges...</p>";

    const rank = parseInt(document.getElementById("rank").value);
    const branch = document.getElementById("branch").value;
    const category = document.getElementById("category").value;

    if (isNaN(rank) || rank <= 0) {
        resultsDiv.innerHTML = "<p>Please enter a valid positive rank.</p>";
        return;
    }

    const requestData = {
        rank: rank,
        branch: branch,
        category: category
    };

    fetch("http://localhost:9090/api/predict-colleges", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Server returned an error: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        resultsDiv.innerHTML = "";

        if (data.length === 0) {
            resultsDiv.innerHTML = "<p>No colleges found for this input.</p>";
            return;
        }

        data.forEach(college => {
            const card = document.createElement("div");
            card.classList.add("college-card");

            const cutoffValue = college.cutoff !== null && college.cutoff !== undefined ? college.cutoff.toLocaleString() : 'Not Available';

            card.innerHTML = `
                <h3>${college.name}</h3>
                <p><strong>Branch:</strong> ${college.branch}</p>
                <p class="cutoff-rank"><strong>Cutoff Rank:</strong> ${cutoffValue}</p>
                <p><strong>Region:</strong> ${college.region}</p>
                <p><strong>Place:</strong> ${college.place}</p>
                <p><strong>Affiliation:</strong> ${college.affl}</p>
            `;
            resultsDiv.appendChild(card);
        });
    })
    .catch(error => {
        console.error("Error:", error);
        document.getElementById("results").innerHTML = "<p>Something went wrong. Check console for details.</p>";
    });
});