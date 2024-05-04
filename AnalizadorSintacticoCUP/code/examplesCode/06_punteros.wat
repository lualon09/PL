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
 i32.const 52
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:var1(type:INT)=(INT:2)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 2
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:var2(type:INT*)=new INT
 i32.const 4
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(var2)=AAdPointer(&AVar(var1))
 i32.const 4
 local.get $localsStart
 i32.add
 ;; generating code for address of AVar(var1)
 i32.const 0
 local.get $localsStart
 i32.add
 ;; end generating code for access address
 i32.store
 ;;end generating code for assignation assign:AVar(var2)=AAdPointer(&AVar(var1))
 ;;generating code for declaration dec:var3(type:INT)=APointer(*AVar(var2))
 ;;generating code for APointer AVar(var2)
 i32.const 4
 local.get $localsStart
 i32.add
i32.load
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for declaration
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AVar(var2)
 i32.const 4
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:var4(type:INT*)=new INT
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(var4)=AVar(var2)
 i32.const 4
 local.get $localsStart
 i32.add
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AVar(var4)=AVar(var2)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AVar(var4)
 i32.const 12
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:varB1(type:BOOL)=(BOOL:False)
 i32.const 16
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB2(type:BOOL*)=new BOOL
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(varB2)=AAdPointer(&AVar(varB1))
 i32.const 20
 local.get $localsStart
 i32.add
 ;; generating code for address of AVar(varB1)
 i32.const 16
 local.get $localsStart
 i32.add
 ;; end generating code for access address
 i32.store
 ;;end generating code for assignation assign:AVar(varB2)=AAdPointer(&AVar(varB1))
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AVar(varB2)
 i32.const 20
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:varB3(type:BOOL*)=new BOOL
 i32.const 24
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(varB3)=AVar(varB2)
 i32.const 20
 local.get $localsStart
 i32.add
 i32.const 24
 local.get $localsStart
 i32.add
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AVar(varB3)=AVar(varB2)
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for APointer AVar(varB3)
 i32.const 24
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:varB4(type:BOOL*)=new BOOL
 i32.const 28
 local.get $localsStart
 i32.add
 i32.const 4
 call $reserveHeap 
 global.get $NP
 i32.store
 ;;end generating code for declaration
 ;;generating code for assignation assign:APointer(*AVar(varB4))=AND(NOT(APointer(*AVar(varB2))),NOT(APointer(*AVar(varB3))))
 ;;generating code for APointer AVar(varB4)
 i32.const 28
 local.get $localsStart
 i32.add
i32.load
 ;;generating code for exp ebinAND(NOT(APointer(*AVar(varB2))),NOT(APointer(*AVar(varB3))))
 ;; generating code for Unary expression
 ;;generating code for access
 ;;generating code for APointer AVar(varB2)
 i32.const 20
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 i32.eqz
 ;; generating code for Unary expression
 ;;generating code for access
 ;;generating code for APointer AVar(varB3)
 i32.const 24
 local.get $localsStart
 i32.add
i32.load
 i32.load
 ;;end generating code for access
 i32.eqz
 i32.and
 i32.store
 ;;end generating code for assignation assign:APointer(*AVar(varB4))=AND(NOT(APointer(*AVar(varB2))),NOT(APointer(*AVar(varB3))))
 ;;generating code for declaration dec:nombre(type:tInfo)
 ;;end generating code for declaration
 ;;generating code for assignation assign:APointer(*AStruct(AVar(nombre).campoPuntero))=(INT:1)
 ;;generating code for APointer AStruct(AVar(nombre).campoPuntero)
 ;;generating code for struct accessAVar(nombre)
 i32.const 32
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;end of generating code for struct accessAVar(nombre)
i32.load
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for assignation assign:APointer(*AStruct(AVar(nombre).campoPuntero))=(INT:1)
 ;;generating code for assignation assign:AStruct(AVar(nombre).campo)=(INT:2)
 ;;generating code for struct accessAVar(nombre)
 i32.const 32
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(nombre)
 ;;generating code for EConst
 i32.const 2
 i32.store
 ;;end generating code for assignation assign:AStruct(AVar(nombre).campo)=(INT:2)
 ;;generating code for declaration dec:nombrePuntero(type:tInfo*)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(APointer(*AVar(nombrePuntero)).campo)=(INT:0)
 ;;generating code for struct accessAPointer(*AVar(nombrePuntero))
 ;;generating code for APointer AVar(nombrePuntero)
 i32.const 40
 local.get $localsStart
 i32.add
i32.load
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAPointer(*AVar(nombrePuntero))
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for assignation assign:AStruct(APointer(*AVar(nombrePuntero)).campo)=(INT:0)
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


