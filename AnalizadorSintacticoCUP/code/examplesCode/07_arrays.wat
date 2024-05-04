(module
(type $_sig_i32i32i32 (func (param i32 i32 i32) ))
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $show (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $preMain)
(func $preMain 
 (local $temp i32)
 (local $localsStart i32)
 i32.const 4
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 call $main
 drop
 call $freeStack
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 960
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:array1(type:List<INT>[(INT:5)])=[(INT:1), (INT:4), (INT:6), (INT:7), (INT:8)]
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 4
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 6
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 7
 i32.store
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 16
 i32.add
 ;;generating code for EConst
 i32.const 8
 i32.store
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 20
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:5))
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 5
 i32.lt_s
 i32.eqz
 br_if 1
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array1)
 i32.const 0
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 20
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for declaration dec:array2(type:List<INT>[(INT:5)])=AVar(array1)
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 5
 call $copyn
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 40
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:5))
 ;;generating code for access
 i32.const 40
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 5
 i32.lt_s
 i32.eqz
 br_if 1
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 40
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 40
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 40
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array2)
 i32.const 20
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 40
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 40
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for declaration dec:array3(type:List<INT>[(INT:7)])
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 68
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:7))
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 7
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for assignation assign:AArray (AVar(array3)[AVar(i)])=AVar(i)
 i32.const 68
 local.get $localsStart
 i32.add
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 7
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array3)
 i32.const 40
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AArray (AVar(array3)[AVar(i)])=AVar(i)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 7
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array3)
 i32.const 40
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 68
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 68
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for declaration dec:var1(type:INT)=SUM(AArray (AVar(array1)[(INT:2)]),AArray (AVar(array3)[(INT:4)]))
 i32.const 68
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AArray (AVar(array1)[(INT:2)]),AArray (AVar(array3)[(INT:4)]))
 ;;generating code for access
 ;;generating code for index of array(INT:2) to see if it's correct
 ;;generating code for EConst
 i32.const 2
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for EConst
 i32.const 2
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of array(INT:2)
 ;;generating code for EConst
 i32.const 2
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array1)
 i32.const 0
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 ;;generating code for access
 ;;generating code for index of array(INT:4) to see if it's correct
 ;;generating code for EConst
 i32.const 4
i32.const 7
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for EConst
 i32.const 4
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of array(INT:4)
 ;;generating code for EConst
 i32.const 4
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(array3)
 i32.const 40
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 i32.add
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:arrayB1(type:List<BOOL>[(INT:2)])=[(BOOL:True), (BOOL:False)]
 i32.const 72
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 72
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB1(type:BOOL)=AArray (AVar(arrayB1)[(INT:1)])
 ;;generating code for index of array(INT:1) to see if it's correct
 ;;generating code for EConst
 i32.const 1
i32.const 2
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for EConst
 i32.const 1
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of array(INT:1)
 ;;generating code for EConst
 i32.const 1
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(arrayB1)
 i32.const 72
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.const 80
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 i32.const 80
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:arrayMult(type:List<List<INT>[(INT:2)]>[(INT:2)])=[[(INT:1), (INT:2)], [(INT:2), (INT:3)]]
 i32.const 84
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 84
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 i32.const 84
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 i32.const 84
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 100
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:2))
 ;;generating code for access
 i32.const 100
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 2
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:j(type:INT)=(INT:0)
 i32.const 104
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(j),(INT:2))
 ;;generating code for access
 i32.const 104
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 2
 i32.lt_s
 i32.eqz
 br_if 1
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(j) to see if it's correct
 ;;generating code for access
 i32.const 104
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 2
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 104
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 104
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AVar(arrayMult)[AVar(i)])
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 100
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 2
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 100
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 100
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 8
 i32.mul
 ;;generating code for access arrayAVar(arrayMult)
 i32.const 84
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 i32.const 104
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(j),(INT:1))
 ;;generating code for access
 i32.const 104
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 100
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 100
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for declaration dec:arrayMult3(type:List<List<List<INT>[(INT:5)]>[(INT:6)]>[(INT:7)])
 ;;end generating code for declaration
 ;;generating code for IFor
 ;;generating code for declaration dec:i(type:INT)=(INT:0)
 i32.const 940
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(i),(INT:7))
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 7
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:j(type:INT)=(INT:0)
 i32.const 944
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(j),(INT:6))
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 6
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for IFor
 ;;generating code for declaration dec:k(type:INT)=(INT:0)
 i32.const 948
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 block
 loop
 ;;generating code for exp ebinLESS(AVar(k),(INT:5))
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 5
 i32.lt_s
 i32.eqz
 br_if 1
 ;;generating code for assignation assign:AArray (AArray (AArray (AVar(arrayMult3)[AVar(i)])[AVar(j)])[AVar(k)])=AVar(k)
 i32.const 948
 local.get $localsStart
 i32.add
 ;;generating code for index of arrayAVar(k) to see if it's correct
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(k)
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AArray (AVar(arrayMult3)[AVar(i)])[AVar(j)])
 ;;generating code for index of arrayAVar(j) to see if it's correct
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 6
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 20
 i32.mul
 ;;generating code for access arrayAArray (AVar(arrayMult3)[AVar(i)])
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 7
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 120
 i32.mul
 ;;generating code for access arrayAVar(arrayMult3)
 i32.const 100
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AArray (AArray (AArray (AVar(arrayMult3)[AVar(i)])[AVar(j)])[AVar(k)])=AVar(k)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of arrayAVar(k) to see if it's correct
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(k)
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 4
 i32.mul
 ;;generating code for access arrayAArray (AArray (AVar(arrayMult3)[AVar(i)])[AVar(j)])
 ;;generating code for index of arrayAVar(j) to see if it's correct
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 6
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(j)
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 20
 i32.mul
 ;;generating code for access arrayAArray (AVar(arrayMult3)[AVar(i)])
 ;;generating code for index of arrayAVar(i) to see if it's correct
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.const 7
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of arrayAVar(i)
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.const 120
 i32.mul
 ;;generating code for access arrayAVar(arrayMult3)
 i32.const 100
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(k)=SUM(AVar(k),(INT:1))
 i32.const 948
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(k),(INT:1))
 ;;generating code for access
 i32.const 948
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(k)=SUM(AVar(k),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 i32.const 944
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(j),(INT:1))
 ;;generating code for access
 i32.const 944
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(j)=SUM(AVar(j),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;;generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 i32.const 940
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(AVar(i),(INT:1))
 ;;generating code for access
 i32.const 940
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(i)=SUM(AVar(i),(INT:1))
 br 0
 end
 end
 ;;end generating code for IFor
 ;; generating code for IReturn
 ;;generating code for EConst
 i32.const 0
 call $freeStack
 return
)
(func $reserveStack (param $size i32)
   (result i32)
   global.get $MP
   global.get $SP
   global.set $MP
   global.get $SP
   local.get $size
   i32.add
   global.set $SP
   global.get $SP
   global.get $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)

(func $freeStack (type $_sig_void)
   global.get $MP
   global.set $SP
   global.get $MP
   i32.load
   global.set $MP   
)

(func $reserveHeap (type $_sig_i32)
   (param $size i32)


   global.get $NP
   local.get $size
   i32.sub
   global.set $NP

   global.get $SP
   global.get $NP 
   i32.gt_u ;; comprobamos si SP es mayor que NP
   if
   i32.const 3
   call $exception ;; se han cruzado, error
   end
)

(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       local.get $n
       i32.eqz
       br_if 1
       local.get $n
       i32.const 1
       i32.sub
       local.set $n
       local.get $dest
       local.get $src
       i32.load
       i32.store
       local.get $dest
       i32.const 4
       i32.add
       local.set $dest
       local.get $src
       i32.const 4
       i32.add
       local.set $src
       br 0
     end
   end
)
(export "memory" (memory 0))
(export "init" (func $preMain))
)


