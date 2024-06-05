document.addEventListener("DOMContentLoaded", () => {
    const toggleButtons = document.querySelectorAll(".toggleButton");
    toggleButtons.forEach(button => {
        button.addEventListener("click", () => {
            const container = button.parentElement;
            const containerContent = container.querySelector(".container-content");
            const isExpanded = containerContent.classList.contains("show");
            if (isExpanded) {
                containerContent.style.maxHeight = null;
                containerContent.classList.remove("show");
            } else {
                containerContent.style.maxHeight = containerContent.scrollHeight + "px";
                containerContent.classList.add("show");
            }
        });
    });
});
