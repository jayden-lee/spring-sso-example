# Oauth Authorization Server

## End points
1. o

## DB Scheme

### oauth_client_details
> 클라이언트 정보를 저장하는 테이블

```
create table IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);
```

- client_id : 클라이언트 아이디
- resource_ids : 리소스 아이디
- client_secret : 클라이언트 비밀번호
- scope : 발급된 액세스 토큰의 범위
- authorized_grant_types : OAuth2 승인 방식 종류
- web_server_redirect_uri : 리다이렉트 URI 주소
- access_token_validity : 액세스 토큰 유효 시간
- refresh_token_validity : 리프레시 토큰 유효 시간