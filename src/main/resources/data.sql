delete from company_staff_in_out;
delete from company_service;
delete from building_staff;
delete from company_staff;
delete from company;
delete from service;

insert into service(name,type,unit_price) 
	values("Vệ sinh", "Vệ sinh", 500000);
insert into service(name,type,unit_price) 
	values("Ăn uống", "Trông giữ xe", 5000000);
insert into service(name,type,unit_price) 
	values("Trông giữ xe", "Trông giữ xe", 500000);
insert into service(name,type,unit_price)
	values("Bảo vệ", "Bảo vệ", 500000);
	
insert into company(name,tax_id,charter_capital,operation_field,number_of_staff,address_in_building,phone,space_area) 
	values("Long Biên","433432312",1000000000,"Gỗ",2,"Tầng 2","0396123411",50);
insert into company(name,tax_id,charter_capital,operation_field,number_of_staff,address_in_building,phone,space_area) 
	values("Lâm Thao","0224521123",2999999999,"Báo",0,"Tầng 4","0312421241",45);
insert into company(name,tax_id,charter_capital,operation_field,number_of_staff,address_in_building,phone,space_area) 
	values("W3Dev","402123102",1999999999,"IT",3,"Tầng 5","0396156993",36);

insert into company_staff(name,date_of_birth,phone,card_number,company_id) 
	values("Nguyen Hai Nam","1999-12-12","03124512123","026091020102",1);
insert into company_staff(name,date_of_birth,phone,card_number,company_id) 
	values("Nguyen Thi Lan Anh","1999-02-02","039614567","026099001102",3);
insert into company_staff(name,date_of_birth,phone,card_number,company_id) 
	values("Nguyễn Hải Yến","1999-02-12","0396145217","026099001231",3);
insert into company_staff(name,date_of_birth,phone,card_number,company_id) 
	values("Nguyễn Việt Khánh","1999-03-02","039614127","026099001111",3);
insert into company_staff(name,date_of_birth,phone,card_number,company_id) 
	values("Hoang Ha Xoan","1999-11-02","0396112231","026099000999",1);	
	
insert into building_staff(name,date_of_birth,address,phone,ranks,position,service_id)
	values("Dương Văn Linh","1999-06-15","Vinh Phuc","0396156993", 2, "Nhân viên bảo vệ", 2);
insert into building_staff(name,date_of_birth,address,phone,ranks,position,service_id)
	values("Duong Thu Ha","1999-10-10","Ha Noi","03961910993", 1, "Nhân viên nấu ăn", 1);
insert into building_staff(name,date_of_birth,address,phone,ranks,position,service_id) 
	values("Hoang Ha Lam","1999-08-08","Ha Noi","039612345", 3, "Nhân viên bảo vệ", 2);
insert into building_staff(name,date_of_birth,address,phone,ranks,position,service_id)
	values("Nguyen Duc Huy","1999-11-11","Phu Tho","039623412", 2, "Nhân viên sửa chữa", 3);
	
insert into company_service(company_id,service_id,created_on) 
	values(1,1,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(1,4,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(2,1,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(2,4,'2020-10-19');
	insert into company_service(company_id,service_id,created_on) 
	values(3,1,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(3,4,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(1,2,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(2,3,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(3,2,'2020-10-19');
insert into company_service(company_id,service_id,created_on) 
	values(3,3,'2020-10-19');
			
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(1,"Ra","Tầng 1","2020-10-19 07:10:00");
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(1,"Vào","Tầng 1","2020-10-19 10:10:00");	
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(2,"Ra","Hầm B1","2020-10-20 07:00:00");
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(2,"Vào","Hầm B1","2020-10-20 10:11:00");	
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(2,"Ra","Hầm B2","2020-10-20 12:30:00");
insert into company_staff_in_out(company_staff_id,in_out,address_in_out,time)
	values(2,"Vào","Hầm B1","2020-10-20 17:10:00");	
