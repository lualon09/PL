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
 ;; generating code of function calculaFibonacci
(func $calculaFibonacci
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 16
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:res(type:INT)
 ;;end generating code for declaration
 ;;generating code for ifElse
 ;;generating code for exp ebinLEQ(AVar(n),(INT:1))
 ;;generating code for access
 ;; loading paramn
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.le_s
 if
 ;;generating code for assignation assign:AVar(res)=(INT:1)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for assignation assign:AVar(res)=(INT:1)
 else
 ;; generating code for IShow
 ;;generating code for access
 ;; loading paramn
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for assignation assign:AVar(res)=SUM(call:calculaFibonacci([SUB(AVar(n),(INT:1))]),call:calculaFibonacci([SUB(AVar(n),(INT:2))]))
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for exp ebinSUM(call:calculaFibonacci([SUB(AVar(n),(INT:1))]),call:calculaFibonacci([SUB(AVar(n),(INT:2))]))
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument SUB(AVar(n),(INT:1))
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for exp ebinSUB(AVar(n),(INT:1))
 ;;generating code for access
 ;; loading paramn
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 1
 i32.sub
 i32.store
 ;; end copying arguments
 call $calculaFibonacci
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument SUB(AVar(n),(INT:2))
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for exp ebinSUB(AVar(n),(INT:2))
 ;;generating code for access
 ;; loading paramn
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for EConst
 i32.const 2
 i32.sub
 i32.store
 ;; end copying arguments
 call $calculaFibonacci
 i32.add
 i32.store
 ;;end generating code for assignation assign:AVar(res)=SUM(call:calculaFibonacci([SUB(AVar(n),(INT:1))]),call:calculaFibonacci([SUB(AVar(n),(INT:2))]))
 end
 ;; generating code for IShow
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IReturn
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 call $freeStack
 return
 call $freeStack
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 16
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:n(type:INT)=(INT:5)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 5
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:sol(type:INT)=call:calculaFibonacci([AVar(n)])
 i32.const 4
 local.get $localsStart
 i32.add
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(n)
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;; end copying arguments
 call $calculaFibonacci
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 i32.const 4
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
 call $freeStack
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
   i32.load
   i32.load offset=4
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
)
