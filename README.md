# kwang-bungae-BE



# 🔥 Git 규칙 

## ① 브랜치(branch) 이름 
- 기능 개발  
  git branch **feature**/기능요약  
  `ex) git branch feature/login`   
  `ex) git branch feature/ad_memberAll` 
 
- 버그/오류 수정
  git branch **hotfix**/기능요약  
  `ex) git branch hotfix/mypage_myArticle`   
  `ex) git branch hotfix/u_faqList`  

## ② 커밋(commit)
- 하나의 커밋에는 한 단위의 작업 넣기  
  ◽ 한 작업을 여러 버전에 걸쳐 커밋 ❌  
  ◽ 여러 작업을 한 버전에 커밋 ❌   
    → 여러 개 같이 커밋하면, 나중에 그것들 중 하나만 취소해야 될 일 발생할 수 있으니까⋯⋯!   
  ◽ 커밋 최소 단위로 하기, 하나의 의도만 가지고 !  
    → 버그 수정 + 새 기능 추가 를 같이 커밋 ❌ 

## ③ 커밋 메시지
🌟 어떤 작업이 이뤄졌는지 알아볼 수 있게 작성 !  
→ 이름 아무렇게나 작성해놓으면, 나중에 본인도 거기서 무슨 작업했는지 기억 못함⋯!   
`ex) git commit -m 'haha'` 

- 명령문 형태로, 제목 첫 글자는 대문자로 (타입 말고 제목을!)
- 아래에서 필요한 타입 사용 
  
|타입|내용|
|------|------|
|feat|새로운 기능 추가|
|fix| 버그/오류 수정|
|docs| 문서 수정 |
|style| 코드 포맷 변경, 세미콜론 누락, 코드 변경 없음|
|design| 사용자 UI 디자인 변경 (CSS 등)|
|move| 코드나 파일의 이동|
|rename| 이름 변경|
|remove| 삭제|  


`ex) git commit -m 'feat: Add map API'`  
`ex) git commit -am 'docs: Update README.md'`  
