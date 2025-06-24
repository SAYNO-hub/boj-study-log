# 📘 BOJ 문제 풀이 GitHub 관리 요약

## 1. 브랜치 전략

- **main**: 정리된 최종 풀이 저장용  
- **solve/문제번호_이름**: 문제 풀이용 작업 브랜치

예시:  
git checkout -b solve/10816_number_count

## 2. 커밋 메시지 형식

- feat: BOJ 10816 숫자 카드 2 풀이
- refactor: BOJ 10816 코드 리팩토링
- docs: BOJ 10816 설명 추가
- fix: BOJ 10816 출력 조건 수정

## 3. 문제 푼 후 Git 흐름

### 1. 브랜치 생성
git checkout -b solve/문제번호_문제이름

### 2. 코드 작성

### 3. 스테이징 및 커밋
git add .
git commit -m "feat: BOJ 문제번호 문제이름 풀이"

### 4. main 브랜치로 이동 및 병합
git checkout main
git merge solve/문제번호_문제이름

### 5. 작업 브랜치 삭제
git branch -d solve/문제번호_문제이름

### 6. GitHub에 푸시
git push origin main


## 4. 폴더 정리 예시

- types/ → 알고리즘 유형별 관리
- weeks/01_week_20250624/ → 주차별 관리

예)
- types/binary_search/BOJ_10816.java  
- weeks/01_week_20250624/BOJ_10816.java

## 5. README 예시

| 날짜       | 문제번호 | 제목        | 유형           | 풀이 경로                             |
|------------|----------|-------------|----------------|----------------------------------------|
| 2025.06.24 | 10816    | 숫자 카드 2 | Binary Search  | [코드 보기](./types/binary_search/boj_10816_숫자카드2.java) |
