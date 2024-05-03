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
 i32.const 48
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:var1(type:INT)=(INT:4)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 4
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var2(type:INT)=(INT:3)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB1(type:BOOL)=OR(AND((BOOL:False),(BOOL:False)),(BOOL:True))
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinOR(AND((BOOL:False),(BOOL:False)),(BOOL:True))
 ;;generating code for exp ebinAND((BOOL:False),(BOOL:False))
 ;;generating code for EConst
 i32.const 0
 ;;generating code for EConst
 i32.const 0
 i32.and
 ;;generating code for EConst
 i32.const 1
 i32.or
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB2(type:BOOL)=OR(AND((BOOL:False),(BOOL:False)),(BOOL:True))
 i32.const 12
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinOR(AND((BOOL:False),(BOOL:False)),(BOOL:True))
 ;;generating code for exp ebinAND((BOOL:False),(BOOL:False))
 ;;generating code for EConst
 i32.const 0
 ;;generating code for EConst
 i32.const 0
 i32.and
 ;;generating code for EConst
 i32.const 1
 i32.or
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB3(type:BOOL)=OR(GREATER(AVar(var1),AVar(var2)),EQUAL(AVar(var1),AVar(var2)))
 i32.const 16
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinOR(GREATER(AVar(var1),AVar(var2)),EQUAL(AVar(var1),AVar(var2)))
 ;;generating code for exp ebinGREATER(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.gt_s
 ;;generating code for exp ebinEQUAL(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.eq
 i32.or
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB4(type:BOOL)=AND(LEQ(AVar(var1),AVar(var2)),(BOOL:True))
 i32.const 20
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinAND(LEQ(AVar(var1),AVar(var2)),(BOOL:True))
 ;;generating code for exp ebinLEQ(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.le_s
 ;;generating code for EConst
 i32.const 1
 i32.and
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB5(type:BOOL)=OR(DISTINCT(AVar(var1),AVar(var2)),AND(GREATER(AVar(var1),AVar(var2)),(BOOL:False)))
 i32.const 24
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinOR(DISTINCT(AVar(var1),AVar(var2)),AND(GREATER(AVar(var1),AVar(var2)),(BOOL:False)))
 ;;generating code for exp ebinDISTINCT(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.ne
 ;;generating code for exp ebinAND(GREATER(AVar(var1),AVar(var2)),(BOOL:False))
 ;;generating code for exp ebinGREATER(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.gt_s
 ;;generating code for EConst
 i32.const 0
 i32.and
 i32.or
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB6(type:BOOL)=OR(DISTINCT(AVar(var1),AVar(var2)),AND(GREATER(AVar(var1),AVar(var2)),(BOOL:False)))
 i32.const 28
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinOR(DISTINCT(AVar(var1),AVar(var2)),AND(GREATER(AVar(var1),AVar(var2)),(BOOL:False)))
 ;;generating code for exp ebinDISTINCT(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.ne
 ;;generating code for exp ebinAND(GREATER(AVar(var1),AVar(var2)),(BOOL:False))
 ;;generating code for exp ebinGREATER(AVar(var1),AVar(var2))
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.gt_s
 ;;generating code for EConst
 i32.const 0
 i32.and
 i32.or
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB7(type:BOOL)=AND(EQUAL(NOT((BOOL:True)),(BOOL:False)),LESS(AVar(var2),AVar(var1)))
 i32.const 32
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinAND(EQUAL(NOT((BOOL:True)),(BOOL:False)),LESS(AVar(var2),AVar(var1)))
 ;;generating code for exp ebinEQUAL(NOT((BOOL:True)),(BOOL:False))
 ;; generating code for Unary expression
 ;;generating code for EConst
 i32.const 1
 i32.eqz
 ;;generating code for EConst
 i32.const 0
 i32.eq
 ;;generating code for exp ebinLESS(AVar(var2),AVar(var1))
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.lt_s
 i32.and
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB8(type:BOOL)=AND(NOT(DISTINCT((BOOL:True),(BOOL:False))),LESS(AVar(var2),AVar(var1)))
 i32.const 36
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinAND(NOT(DISTINCT((BOOL:True),(BOOL:False))),LESS(AVar(var2),AVar(var1)))
 ;; generating code for Unary expression
 ;;generating code for exp ebinDISTINCT((BOOL:True),(BOOL:False))
 ;;generating code for EConst
 i32.const 1
 ;;generating code for EConst
 i32.const 0
 i32.ne
 i32.eqz
 ;;generating code for exp ebinLESS(AVar(var2),AVar(var1))
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.lt_s
 i32.and
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 12
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 16
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 20
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 24
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 28
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 32
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 36
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
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


