const courseList = document.getElementById('courses-section')
const searchBar6To8 = document.getElementById('search-bar-6-to-8')


const allCoursesSixToEight = [];


fetch("https://roboworld.greenplant-7af38050.westeurope.azurecontainerapps.io/courses/sixToEight/api").
then(response => response.json()).
then(data => {
    for (let course of data) {
        allCoursesSixToEight.push(course);
    }
    console.log(allCoursesSixToEight);
})


searchBar6To8.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar6To8.value.toLowerCase();
    let filteredCourses = allCoursesSixToEight.filter(course => {
        return course.title.toLowerCase().includes(searchingCharacters);
    });
    displayCourse(filteredCourses);
})


const displayCourse = (courses) => {
    courseList.innerHTML = courses
        .map((c) => {
            return `
         <article class="courses6-8-article courses-article" id="courses-article">
        <h3>${c.title}</h3>
        <p >${c.description}</p>
        <a class="see-more" href="/title/${c.id}">See more</a>
        </article>    `
        })
        .join('');
}
