select * from MEMBER;
select * from trainer;

select * from member m, trainer t where m.trainer_no=t.trainer_no;

select * from member m, trainer t where m.trainer_no=t.trainer_no and m.mem_name = '김동원';


select * from trainer where trainer_name='선택안함';