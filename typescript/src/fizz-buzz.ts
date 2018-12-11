export function of(num): String{
  var r = '';
  if(num % 3 == 0) {
    r += "Fizz";
  }
  if(num % 5 == 0) {
    r += "Buzz";
  }
  return r !== '' ? r : String(num);
}

export function until(num): String {
  return [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15].map(n => of(n)).join(' ')
}
