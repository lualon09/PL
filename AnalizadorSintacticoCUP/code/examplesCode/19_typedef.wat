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
 ;; generating code of function suma
(func $suma
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
 ;; generating code for IReturn
 ;;generating code for exp ebinSUM(AVar(a),AVar(b))
 ;;generating code for access
 ;; loading parama
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 ;;generating code for access
 ;; loading paramb
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.add
 call $freeStack
 return
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 60
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:a(type:INT)=(INT:3)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:b(type:INT)=(INT:4)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 4
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:c(type:INT)=(INT:3)
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for exp ebinSUM(call:suma([AVar(a), AVar(b)]),call:suma([AVar(b), AVar(c)]))
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(a)
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
;; Treating the argument AVar(b)
 i32.const 4
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;; end copying arguments
 call $suma
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(b)
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
;; Treating the argument AVar(c)
 i32.const 4
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 8
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;; end copying arguments
 call $suma
 i32.add
 call $show
 ;;generating code for declaration dec:lista(type:List<INT>[(INT:5)])=[(INT:1), (INT:2), (INT:3), (INT:4), (INT:5)]
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;generating code for EConst
 i32.const 4
 i32.store
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 16
 i32.add
 ;;generating code for EConst
 i32.const 5
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for index of array(INT:0) to see if it's correct
 ;;generating code for EConst
 i32.const 0
i32.const 5
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for EConst
 i32.const 0
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of array(INT:0)
 ;;generating code for EConst
 i32.const 0
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(lista)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:p(type:INT*)=new INT
 i32.const 32
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:APointer(*AVar(p))=(INT:4)
 ;;generating code for APointer AVar(p)
 i32.const 32
 local.get $localsStart
 i32.add
i32.load
 ;;generating code for EConst
 i32.const 4
 i32.store
 ;;end generating code for assignation assign:APointer(*AVar(p))=(INT:4)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AVar(p)
 i32.const 32
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:p2(type:INT*)=new INT
 i32.const 36
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:APointer(*AVar(p2))=(INT:5)
 ;;generating code for APointer AVar(p2)
 i32.const 36
 local.get $localsStart
 i32.add
i32.load
 ;;generating code for EConst
 i32.const 5
 i32.store
 ;;end generating code for assignation assign:APointer(*AVar(p2))=(INT:5)
 ;;generating code for declaration dec:lista2(type:List<INT*>[(INT:2)])=[AVar(p), AVar(p2)]
 i32.const 40
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;generating code for access
 i32.const 32
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 i32.const 40
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;generating code for access
 i32.const 36
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AArray (AVar(lista2)[(INT:0)])
 ;;generating code for index of array(INT:0) to see if it's correct
 ;;generating code for EConst
 i32.const 0
i32.const 2
i32.ge_s
if
i32.const 3
call $exception
end
i32.const 0
 ;;generating code for EConst
 i32.const 0
i32.gt_s
if
i32.const 3
call $exception
end
 ;;generating code for index of array(INT:0)
 ;;generating code for EConst
 i32.const 0
 i32.const 4
 i32.mul
 ;;generating code for access arrayAVar(lista2)
 i32.const 40
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AArray (AVar(lista2)[(INT:1)])
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
 ;;generating code for access arrayAVar(lista2)
 i32.const 40
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:aux(type:tInfo)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(AVar(aux).a)=(INT:2)
 ;;generating code for struct accessAVar(aux)
 i32.const 48
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(aux)
 ;;generating code for EConst
 i32.const 2
 i32.store
 ;;end generating code for assignation assign:AStruct(AVar(aux).a)=(INT:2)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(aux)
 i32.const 48
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(aux)
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


