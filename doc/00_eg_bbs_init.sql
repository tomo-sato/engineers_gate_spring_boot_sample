/* �X�L�[�}�iDB�j�쐬 */
CREATE SCHEMA IF NOT EXISTS `eg_bbs` DEFAULT CHARACTER SET utf8 ;

/* ���[�U�[�쐬 */
CREATE USER 'eg_user'@'localhost' IDENTIFIED BY 'eg_pass';

/* ���[�U�[�����ݒ� */
GRANT ALL PRIVILEGES ON eg_bbs.* TO 'eg_user'@'localhost';
FLUSH PRIVILEGES;

/* ���[�U�[�폜�i���הO�A�������@�B�R�����g���O���Ďg�p����B�j */
-- DROP USER 'eg_user'@'localhost';
