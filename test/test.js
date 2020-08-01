// 设定的总时间
let time = 20;
// 走过的时间
let duration = 0;
// 进行百分比 = 走过的时间 / 设定的时间
let processing = 0;
// 计时器
let counting = null;

function startCounting(counting, time, duration) {
  console.log("开始了!");
  let processing = 0;
  counting = setInterval(() => {
    if (time - duration > 0) {
      duration++;
      console.log("duration: " + duration);
      processing = parseInt((duration * 100) / time);
      console.log("processing: " + processing);
      //
      setTimeout(() => {
        clearInterval(counting);
        console.log("停止了");
      }, 2000);
    } else {
      console.log("time out");
      clearInterval(counting);
      return;
    }
  }, 1000);
}

// function stopInterval(counting, time, duration) {
//   clearInterval(counting);
//   console.log("stopInterval");
// }

startCounting(counting, time, duration);

// // clearInterval(counting);
// setTimeout(() => {
//   clearInterval(counting);
//   console.log("停止了");
// }, 2000);
