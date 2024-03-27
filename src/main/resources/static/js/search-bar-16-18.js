const courseList = document.getElementById('courses-section')
const searchBar16To18 = document.getElementById('search-bar-16-to-18')


const allCourses16To18 = [];


fetch("https://localhost:8080/courses/thirteenToFifteen/api").
then(response => response.json()).
then(data => {
    for (let course of data) {
        allCourses16To18.push(course);
    }
    console.log(allCourses16To18);
})


searchBar16To18.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar16To18.value.toLowerCase();
    let filteredCourses = allCourses16To18.filter(course => {
        return course.title.toLowerCase().includes(searchingCharacters);
    });
    displayCourse(filteredCourses);
})


const displayCourse = (courses) => {
    courseList.innerHTML = courses
        .map((c) => {
            return `
         <article class="courses16-18-article courses-article" id="courses-article">
        <h3>${c.title}</h3>
        <p >${c.description}</p>
        <a class="see-more" href="/title/${c.id}">See more</a>
        </article>    `
        })
        .join('');
}
