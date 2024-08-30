document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById("confirmationModal");
    const closeBtn = document.querySelector(".close");
    const confirmYesBtn = document.getElementById("confirmYes");
    const confirmNoBtn = document.getElementById("confirmNo");
    let studentId;  // Pour stocker l'ID de l'étudiant

    // Ouvrir le modal lorsque le bouton "Supprimer" est cliqué
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', (event) => {
            studentId = button.getAttribute('data-id'); // Récupérer l'ID de l'étudiant
            modal.style.display = "block";
        });
    });

    // Fermer le modal quand l'utilisateur clique sur la croix
    closeBtn.addEventListener('click', () => {
        modal.style.display = "none";
    });

    // Fermer le modal quand l'utilisateur clique sur "Non"
    confirmNoBtn.addEventListener('click', () => {
        modal.style.display = "none";
    });

    // Envoyer une requête DELETE et actualiser la page quand l'utilisateur clique sur "Oui"
    confirmYesBtn.addEventListener('click', () => {
        if (studentId) {
            fetch(`/students/${studentId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            }).then(response => {
                if (response.ok) {
                    window.location.reload(); // Actualiser la page si la suppression est réussie
                } else {
                    console.error('Échec de la suppression de l\'étudiant');
                }
            }).catch(error => {
                console.error('Erreur:', error);
            }).finally(() => {
                modal.style.display = "none";
            });
        }
    });

    // Fermer le modal si l'utilisateur clique en dehors de celui-ci
    window.addEventListener('click', (event) => {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
});
