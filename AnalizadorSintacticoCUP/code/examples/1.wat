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
 i32.const 12
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
i32.const 8
i32.const 1
call $copyn$
;; generating code of const var
 ;;generating code for EConst
 i32.const 0
i32.store
;; generating code of const var2
i32.const 1
call $copyn$
 call $main
 call $freeStack
)
;; generating code of const var
 ;;generating code for EConst
 i32.const 0
i32.store
;; generating code of const var2
i32.const 1
call $copyn$
;; generating code of function prueba
(func $prueba
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 12
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for exp ebinSUM(AVar(constantesNo),(INT:1))
 ;;generating code for access
;; loading paramconstantesNo
i32.const 0
local.get $localsStart
i32.add
i32.load
i32.load
 ;;generating code for EConst
 i32.const 1
 i32.add
call $freeStack
return
 call $freeStack
)
;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 12
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
i32.const 0
local.get $localsStart
i32.add
i32.const 1
call $copyn$
 ;;generating code for EConst
 i32.const 0
call $freeStack
return
 call $freeStack
)
(func $reserveStack (param $size i32)
   (result i32)
   get_global $MP
   get_global $SP
   set_global $MP
   get_global $SP
   get_local $size
   i32.add
   set_global $SP
   get_global $SP
   get_global $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)

(func $freeStack (type $_sig_void)
   get_global $MP
   i32.load
   i32.load offset=4
   set_global $SP
   get_global $MP
   i32.load
   set_global $MP   
)

(func $reserveHeap (type $_sig_i32)
   (param $size i32)


   get_global $NP
   get_local $size
   i32.sub
   set_global $NP
  


)

(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       get_local $n
       i32.eqz
       br_if 1
       get_local $n
       i32.const 1
       i32.sub
       set_local $n
       get_local $dest
       get_local $src
       i32.load
       i32.store
       get_local $dest
       i32.const 4
       i32.add
       set_local $dest
       get_local $src
       i32.const 4
       i32.add
       set_local $src
       br 0
     end
   end
)
)
