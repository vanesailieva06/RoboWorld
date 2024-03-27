const courseList = document.getElementById('courses-section')
const searchBar9To12 = document.getElementById('search-bar-9-to-12')


const allCoursesNineToTwelve = [];


fetch("https://localhost:8080/courses/nineToTwelve/api").
then(response => response.json()).
then(data => {
    for (let course of data) {
        allCoursesNineToTwelve.push(course);
    }
    console.log(allCoursesNineToTwelve);
})


searchBar9To12.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar9To12.value.toLowerCase();
    let filteredCourses = allCoursesNineToTwelve.filter(course => {
        return course.title.toLowerCase().includes(searchingCharacters);
    });
    displayCourse(filteredCourses);
})


const displayCourse = (courses) => {
    courseList.innerHTML = courses
        .map((c) => {
            return `
         <article class="courses9-12-article courses-article" id="courses-article">
        <h3>${c.title}</h3>
        <p >${c.description}</p>
        <a class="see-more" href="/title/${c.id}">See more</a>
        </article>    `
        })
        .join('');
}
