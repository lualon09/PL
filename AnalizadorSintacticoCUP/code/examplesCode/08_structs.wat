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
 i32.const 8
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:x(type:INT)=(INT:0)
 i32.const 0
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for declaration
 call $main
 drop
 call $freeStack
)
 ;; generating code of function pruebaStr
(func $pruebaStr
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 36
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:str(type:tInfo)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(AVar(str).var1)=AVar(v1)
 ;; loading paramv1
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for struct accessAVar(str)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AStruct(AVar(str).var1)=AVar(v1)
 ;;generating code for assignation assign:AStruct(AVar(str).var2)=AVar(v2)
 ;; loading paramv2
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for struct accessAVar(str)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AStruct(AVar(str).var2)=AVar(v2)
 ;;generating code for assignation assign:AStruct(AVar(str).varB1)=AVar(v3)
 ;; loading paramv3
 i32.const 8
 local.get $localsStart
 i32.add
 ;;generating code for struct accessAVar(str)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AStruct(AVar(str).varB1)=AVar(v3)
 ;;generating code for assignation assign:AStruct(AVar(str).varB2)=(BOOL:False)
 ;;generating code for struct accessAVar(str)
 i32.const 12
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;end of generating code for struct accessAVar(str)
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for assignation assign:AStruct(AVar(str).varB2)=(BOOL:False)
 ;; generating code for IReturn
 i32.const 12
 local.get $localsStart
 i32.add
 call $freeStack
 return
)
 ;; generating code of function muestraStruct
(func $muestraStruct

 (local $temp i32)
 (local $localsStart i32)
 i32.const 24
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 ;; loading paramstr
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 ;; loading paramstr
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 4
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 ;; loading paramstr
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 ;; loading paramstr
 i32.const 0
 local.get $localsStart
 i32.add
 i32.const 12
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IReturn
 call $freeStack
 return
)
 ;; generating code of function main
(func $main
 (result i32)
 (local $temp i32)
 (local $localsStart i32)
 i32.const 100
 call $reserveStack
 local.set $temp
 global.get $MP
 local.get $temp
 i32.store
 global.get $MP
 i32.const 4
 i32.add
 local.set $localsStart
 ;;generating code for declaration dec:var3(type:INT)=(INT:3)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 3
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:varB4(type:BOOL)=(BOOL:True)
 i32.const 4
 local.get $localsStart
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for declaration
 ;;generating code for declaration dec:str(type:tInfo)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(AVar(str).var1)=AVar(var3)
 i32.const 0
 local.get $localsStart
 i32.add
 ;;generating code for struct accessAVar(str)
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.const 1
 call $copyn
 ;;end generating code for assignation assign:AStruct(AVar(str).var1)=AVar(var3)
 ;;generating code for assignation assign:AStruct(AVar(str).varB1)=NOT(AVar(varB4))
 ;;generating code for struct accessAVar(str)
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;end of generating code for struct accessAVar(str)
 ;; generating code for Unary expression
 ;;generating code for access
 i32.const 4
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.eqz
 i32.store
 ;;end generating code for assignation assign:AStruct(AVar(str).varB1)=NOT(AVar(varB4))
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;; generating code for IShow
 ;;generating code for access
 ;;generating code for struct accessAVar(str)
 i32.const 8
 local.get $localsStart
 i32.add
 i32.const 8
 i32.add
 ;;end of generating code for struct accessAVar(str)
 i32.load
 ;;end generating code for access
 call $show
 ;;generating code for declaration dec:str3(type:tInfo2)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(AStruct(AVar(str3).hola).var1)=(INT:0)
 ;;generating code for struct accessAStruct(AVar(str3).hola)
 ;;generating code for struct accessAVar(str3)
 i32.const 24
 local.get $localsStart
 i32.add
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAVar(str3)
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAStruct(AVar(str3).hola)
 ;;generating code for EConst
 i32.const 0
 i32.store
 ;;end generating code for assignation assign:AStruct(AStruct(AVar(str3).hola).var1)=(INT:0)
 ;;generating code for declaration dec:listastructs(type:List<tInfo>[(INT:1)])
 ;;end generating code for declaration
 ;;generating code for assignation assign:AStruct(AArray (AVar(listastructs)[(INT:0)]).var1)=(INT:1)
 ;;generating code for struct accessAArray (AVar(listastructs)[(INT:0)])
 ;;generating code for index of array(INT:0) to see if it's correct
 ;;generating code for EConst
 i32.const 0
i32.const 1
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
 i32.const 16
 i32.mul
 ;;generating code for access arrayAVar(listastructs)
 i32.const 44
 local.get $localsStart
 i32.add
 i32.add
 ;;end of generating code for access to array
 i32.const 0
 i32.add
 ;;end of generating code for struct accessAArray (AVar(listastructs)[(INT:0)])
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;;end generating code for assignation assign:AStruct(AArray (AVar(listastructs)[(INT:0)]).var1)=(INT:1)
 ;;generating code for declaration dec:solucion(type:tInfo)=call:pruebaStr([AVar(var3), AVar(var3), AVar(varB4)])
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(var3)
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
;; Treating the argument AVar(var3)
 i32.const 4
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 0
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
;; Treating the argument AVar(varB4)
 i32.const 8
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
 call $pruebaStr
 i32.const 60
 local.get $localsStart
 i32.add
 i32.const 4
 call $copyn
 ;;end generating code for declaration
 ;;generating code for declaration dec:sol2(type:tInfo)
 ;;end generating code for declaration
 ;;generating code for assignation assign:AVar(sol2)=call:pruebaStr([(INT:1), (INT:1), (BOOL:True)])
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument (INT:1)
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
;; Treating the argument (INT:1)
 i32.const 4
 local.get $temp
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
;; Treating the argument (BOOL:True)
 i32.const 8
 local.get $temp
 i32.add
 ;;generating code for EConst
 i32.const 1
 i32.store
 ;; end copying arguments
 call $pruebaStr
 i32.const 76
 local.get $localsStart
 i32.add
 i32.const 4
 call $copyn
 ;;end generating code for assignation assign:AVar(sol2)=call:pruebaStr([(INT:1), (INT:1), (BOOL:True)])
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(solucion)
 i32.const 60
 local.get $localsStart
 i32.add
 i32.const 0
 local.get $temp
 i32.add
 i32.const 4
 call $copyn
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 60
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;; end copying arguments
 call $muestraStruct
 ;;generating code for assignation assign:AVar(sol2)=AVar(solucion)
 i32.const 60
 local.get $localsStart
 i32.add
 i32.const 76
 local.get $localsStart
 i32.add
 i32.const 4
 call $copyn
 ;;end generating code for assignation assign:AVar(sol2)=AVar(solucion)
 global.get $SP
 i32.const 4
 i32.add
 local.set $temp
;; Treating the argument AVar(sol2)
 i32.const 76
 local.get $localsStart
 i32.add
 i32.const 0
 local.get $temp
 i32.add
 i32.const 4
 call $copyn
 i32.const 0
 local.get $temp
 i32.add
 ;;generating code for access
 i32.const 76
 local.get $localsStart
 i32.add
 i32.load
 ;;end generating code for access
 i32.store
 ;; end copying arguments
 call $muestraStruct
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


