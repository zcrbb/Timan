//把一个格式为 "12:01"的时间转换成一个对象
export function tto(timeStr: string) {
  let timeArr = timeStr.split(":");
  let hour = parseInt(timeArr[0]);
  let min = parseInt(timeArr[1]);
  return { hour, min };
}

// 把一个格式为 "12:01"的时间转换成一个分钟数
export function ttm(timeStr: string) {
  let timeObj = tto(timeStr);
  return timeObj.hour * 60 + timeObj.min;
}

