package generated

final case class Data1152(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1152 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1152 = copy(value = value * k)
  def addTag(t: String): Data1152 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1152 = copy(meta = meta.updated(k, v))
  def merge(other: Data1152): Data1152 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1152 {
  given Ordering[Data1152] = Ordering.by(_.id)
  def empty: Data1152 = Data1152(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1152 =
    Data1152(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1152] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
