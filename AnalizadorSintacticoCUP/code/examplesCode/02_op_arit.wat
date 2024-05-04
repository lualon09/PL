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
 i32.const 28
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:var1(type:INT)=SUM(MUL((INT:2),(INT:3)),DIV((INT:6),(INT:6)))
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(MUL((INT:2),(INT:3)),DIV((INT:6),(INT:6)))
 ;;generating code for exp ebinMUL((INT:2),(INT:3))
 ;;generating code for EConst
 i32.const 2
 ;;generating code for EConst
 i32.const 3
 i32.mul
 ;;generating code for exp ebinDIV((INT:6),(INT:6))
 ;;generating code for EConst
 i32.const 6
 ;;generating code for EConst
 i32.const 6
 i32.div_s
 i32.add
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var2(type:INT)=DIV(SUM(MUL((INT:2),(INT:3)),(INT:6)),(INT:6))
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinDIV(SUM(MUL((INT:2),(INT:3)),(INT:6)),(INT:6))
 ;;generating code for exp ebinSUM(MUL((INT:2),(INT:3)),(INT:6))
 ;;generating code for exp ebinMUL((INT:2),(INT:3))
 ;;generating code for EConst
 i32.const 2
 ;;generating code for EConst
 i32.const 3
 i32.mul
 ;;generating code for EConst
 i32.const 6
 i32.add
 ;;generating code for EConst
 i32.const 6
 i32.div_s
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var3(type:INT)=DIV(MUL((INT:2),SUM((INT:3),(INT:6))),(INT:6))
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinDIV(MUL((INT:2),SUM((INT:3),(INT:6))),(INT:6))
 ;;generating code for exp ebinMUL((INT:2),SUM((INT:3),(INT:6)))
 ;;generating code for EConst
 i32.const 2
 ;;generating code for exp ebinSUM((INT:3),(INT:6))
 ;;generating code for EConst
 i32.const 3
 ;;generating code for EConst
 i32.const 6
 i32.add
 i32.mul
 ;;generating code for EConst
 i32.const 6
 i32.div_s
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var4(type:INT)=MOD(MUL((INT:4),(INT:5)),(INT:8))
 i32.const 12
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinMOD(MUL((INT:4),(INT:5)),(INT:8))
 ;;generating code for exp ebinMUL((INT:4),(INT:5))
 ;;generating code for EConst
 i32.const 4
 ;;generating code for EConst
 i32.const 5
 i32.mul
 ;;generating code for EConst
 i32.const 8
 i32.rem_s
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var5(type:INT)=SUM((INT:4),MOD((INT:5),(INT:8)))
 i32.const 16
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM((INT:4),MOD((INT:5),(INT:8)))
 ;;generating code for EConst
 i32.const 4
 ;;generating code for exp ebinMOD((INT:5),(INT:8))
 ;;generating code for EConst
 i32.const 5
 ;;generating code for EConst
 i32.const 8
 i32.rem_s
 i32.add
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
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


