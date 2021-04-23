SELECT tokrn_id
FROM tokens
WHERE tokens_expires < now(); -- curdate()