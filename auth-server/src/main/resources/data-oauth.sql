INSERT INTO `oauth_client_details`(
    `client_id`,
    `client_secret`,
    `resource_ids`,
    `scope`,
    `authorized_grant_types`,
    `web_server_redirect_uri`,
    `authorities`,
    `access_token_validity`,
    `refresh_token_validity`,
    `additional_information`,
    `autoapprove`
)
VALUES(
    'client',
    '{bcrypt}$2a$10$jqiciGVV698sp5U3nz3c6O79sNPSUy1lkOXnmmJdXMRtAg.LDfhbO',
    null,
    'read,write',
    'authorization_code,implicit,password,client_credentials,refresh_token',
    null,
    'ROLE_CLIENT',
    36000,
    36000,
    null,
    true
);