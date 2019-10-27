let fornavn = document.getElementById("fornavn");
let etternavn = document.getElementById("etternavn");
let mobil = document.getElementById("mobil");
let passord = document.getElementById("passord");
let passordRepetert = document.getElementById("passordRepetert");
let button = document.getElementById("button");

fornavn.addEventListener("input", sjekkFornavn);
etternavn.addEventListener("input", sjekkEtternavn);
mobil.addEventListener("input", sjekkMobil);
passord.addEventListener("input", sjekkPassord);
passordRepetert.addEventListener("input", sjekkPassordRepetert);

function sjekkMobil() {
    const mobil_id_lengde = mobil.value.length;
    if (mobil_id_lengde !== 8) {
        mobil.setAttribute("style", "border-color: red");
    } else {
        mobil.setAttribute("style", "border-color: green");
    }
}

let fornavnregex = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{2,20}$/;
let etternavnregex = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]{2,20}$/;

function sjekkFornavn() {
    let fornavn1 = fornavn.value;
    if (fornavnregex.test(fornavn1)){
        fornavn.setAttribute("style", "border-color: green");
    } else {
        fornavn.setAttribute("style", "border-color: red");
    }
}

function sjekkEtternavn() {
    let etternavn1 = etternavn.value;
    if (etternavnregex.test(etternavn1)) {
        etternavn.setAttribute("style", "border-color: green");
    } else {
        etternavn.setAttribute("style", "border-color: red");
    }
}

function sjekkPassord() {
    let passord1 = passord.value;
    if (passord1 !== null && passord1.length > 7) {
        if(passord1.length > 12) {
            passord.setAttribute("style", "border-color: green");
        } else {
            passord.setAttribute("style", "border-color: orange");
        }
    } else {
        passord.setAttribute("style", "border-color: red");
    }
}

function sjekkPassordRepetert() {
    let passord1 = passord.value;
    let passord2 = passordRepetert.value;
    if (passord1 === passord2 && passord1 !== null) {
        passordRepetert.setAttribute("style", "border-color: green");
    } else {
        passordRepetert.setAttribute("style", "border-color: red");
    }
}

button.addEventListener("click", event => {
    if(!window.confirm("Send info til tjener?")) {
        event.preventDefault();
    } else {
    }
});

passord.addEventListener("mouseover", event => {
    passord.title = ("Passordstyrke:\n<8 tegn = ugyldig (rødt)\n8-12 tegn = svakt (orangsj)\n13+ tegn = sterkt (grønt)");
});