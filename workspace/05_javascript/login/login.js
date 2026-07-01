const loginForm = document.querySelector('.login-form');

// loginForm에 submit 이벤트 발생 시 function 실행
loginForm.addEventListener('submit', function(event) {
  console.log('로그인 요청');
  

  // 브라우저의 유효성 검증 결과를 확인(required, pattern 등)
  // 폼이 유효(valid)한지 검사하는 메서드
  if(!loginForm.checkValidity()){
    event.preventDefault(); // 브라우저의 기본 동작 취소(submit 취소)
    alert('로그인 실패');
    return;
  }
  alert('로그인 성공');
  // loginForm.submit();
})