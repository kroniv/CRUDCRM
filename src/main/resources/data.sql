
insert into project(id, project_name) values (1,'test1');
insert into project(id, project_name) values (2,'test2');

insert into sub_project(id, sub_project_name, project_id) values (1,'subtest1',1);

insert into task(id,date_of_changed_status,date_of_creation, desc, task_name, task_status, project_id, sub_project_id) values (1,'2023-02-1','2023-02-1','desc desc','tasktest1','new',1,1);