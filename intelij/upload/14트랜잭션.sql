--Ʈ�����
--���� DML���� ���ؼ��� Ʈ������� ������ �� �ֽ��ϴ�. (DDL���� �ڵ�Ŀ��)
--����Ŀ�� Ȯ��
SHOW AUTOCOMMIT;
--����Ŀ�� ON
SET AUTOCOMMIT ON;
--����Ŀ�� OFF
SET AUTOCOMMIT OFF;
-----------------------------------------------------------
SELECT * FROM DEPTS;
DELETE FROM DEPTS WHERE DEPARTMENT_ID =10;
SAVEPOINT DEPT10; --���̺�����Ʈ(Ʈ������� ����)
DELETE FROM DEPTS WHERE DEPARTMENT_ID =20;
SAVEPOINT DEPT20;
DELETE FROM DEPTS WHERE DEPARTMENT_ID=30;
--���̺�����Ʈ�� ���ư���
ROLLBACK TO DEPT20; --���̺�����Ʈ��
ROLLBACK TO DEPT10;
ROLLBACK; --������ Ŀ�����ķ� ���ư�

INSERT INTO DEPTS VALUES(280,'AA',NULL,1800);
COMMIT; --�����Ͱ� �ݿ�
--���迡���� Ʈ����� 4��Ģ ACID


