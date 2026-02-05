// const mytimeout =setTimeout(() => {
//     console.log("This message is displayed after a 3-second delay.");
// }, 3000);
// clearTimeout(mytimeout);
// console.log("Hello");

// const moew = setInterval(() => {
//     console.log("This message is displayed every 3 seconds.");
// }, 3000);

// clearInterval(moew);

let myPromise = new Promise((resolve, reject) => {
    resolve();
    reject();
});

myPromise.then(
    function(value) {
        // let res = 0/ 0;
        console.log("promise got resolved");
    },
    function(error) {
        console.log("promise got rejected")
    }
);


async function getCat() {
    const url = "https://cataas.com/cat?width=200;height=200;json=true";
    const caturl = await fetch(url).then(res => res.json()).then(data => data.url);
    document.getElementById("catimg").src = caturl;
    // return caturl;
}
