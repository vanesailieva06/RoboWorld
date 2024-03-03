let energyBtn = document.getElementById("energy-btn");
let energyP = document.getElementById("energyP");
let energyUl = document.getElementById("energyUl");
let devicesBtn = document.getElementById("devices-btn");
let devices = document.getElementById("devicesUl");
let sensibilityBtn = document.getElementById("sensibility-btn");
let sensibility = document.getElementById("sensibilityUl");
let manipulationBtn = document.getElementById("manipulation-btn");
let manipulation = document.getElementById("manipulationUl");
let movementsBtn = document.getElementById("movements-btn");
let movements = document.getElementById("movementUl");
let otherMovementsBtn = document.getElementById("other-movements-btn");
let otherMovements = document.getElementById("otherMovementUl");
let interactionBtn = document.getElementById("interaction-environment-btn");
let interaction = document.getElementById("interaction-environmentP");
let environmentBtn = document.getElementById("environment-btn");
let humanEnvironment = document.getElementById("human-environmentUl");


function showEnergy() {
    energyP.style.display="block"
    energyUl.style.display="block"
}

energyBtn.addEventListener("mouseover", showEnergy)

function hideEnergy() {
    energyP.style.display="none"
    energyUl.style.display="none"
}

energyBtn.addEventListener("mouseout", hideEnergy)

function showDevices() {
    devices.style.display="block"
}

devicesBtn.addEventListener("mouseover", showDevices)

function hideDevices() {
    devices.style.display="none"
}

devicesBtn.addEventListener("mouseout", hideDevices)

function showSensibility() {
    sensibility.style.display="block"
}

sensibilityBtn.addEventListener("mouseover", showSensibility)

function hideSensibility() {
    sensibility.style.display="none"
}

sensibilityBtn.addEventListener("mouseout", hideSensibility)

function showManipulation() {
    manipulation.style.display="block"
}

manipulationBtn.addEventListener("mouseover", showManipulation)

function hideManipulation() {
    manipulation.style.display="none"
}

manipulationBtn.addEventListener("mouseout", hideManipulation)

function showMovements() {
    movements.style.display="block"
}

movementsBtn.addEventListener("mouseover", showMovements)

function hideMovements() {
    movements.style.display="none"
}

movementsBtn.addEventListener("mouseout", hideMovements)

function showOtherMovements() {
    otherMovements.style.display="block"
}

otherMovementsBtn.addEventListener("mouseover", showOtherMovements)

function hideOtherMovements() {
    otherMovements.style.display="none"
}

otherMovements.addEventListener("mouseout", hideOtherMovements)

function showInteraction() {
    interaction.style.display="block"
}

interactionBtn.addEventListener("mouseover", showInteraction)

function hideInteraction() {
    interaction.style.display="none"
}

interactionBtn.addEventListener("mouseout", hideInteraction)

function showEnvironment() {
    humanEnvironment.style.display="block"
}

environmentBtn.addEventListener("mouseover", showEnvironment)

function hideEnvironment() {
    humanEnvironment.style.display="none"
}

environmentBtn.addEventListener("mouseout", hideEnvironment)