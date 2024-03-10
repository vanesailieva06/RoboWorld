const courseList = document.getElementById('courses-section')
const searchBar13To15 = document.getElementById('search-bar-13-to-15')


const allCourses13To15 = [];


fetch("https://roboworld.greenplant-7af38050.westeurope.azurecontainerapps.io/courses/thirteenToFifteen/api").
then(response => response.json()).
then(data => {
    for (let course of data) {
        allCourses13To15.push(course);
    }
    console.log(allCourses13To15);
})


searchBar13To15.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar13To15.value.toLowerCase();
    let filteredCourses = allCourses13To15.filter(course => {
        return course.title.toLowerCase().includes(searchingCharacters);
    });
    displayCourse(filteredCourses);
})


const displayCourse = (courses) => {
    courseList.innerHTML = courses
        .map((c) => {
            return `
         <article class="courses13-15-article courses-article" id="courses-article">
        <h3>${c.title}</h3>
        <p >${c.description}</p>
        <a class="see-more" href="/title/${c.id}">See more</a>
        </article>    `
        })
        .join('');
}
