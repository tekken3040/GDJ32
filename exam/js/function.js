// console.log('1. ----------------');

document.querySelector('.button1').addEventListener('click', function(){
    let a1 = parseInt( document.querySelector('.number1-1').value );
    let b1 = parseInt( document.querySelector('.number1-2').value );
  
    document.querySelector('.result1-1').value = a1 + b1;
    document.querySelector('.result1-2').value = a1 - b1;
    document.querySelector('.result1-3').value = a1 * b1;
    document.querySelector('.result1-4').value = a1 / b1;
    document.querySelector('.result1-5').value = a1 % b1;
  });
  
  // console.log('더하기 : ' + (a1 + b1));
  // console.log('빼기 : ' + (a1 - b1));
  // console.log('곱하기 : ' + (a1 * b1));
  // console.log('나누기 : ' + (a1 / b1));
  // console.log('나머지 : ' + (a1 % b1));