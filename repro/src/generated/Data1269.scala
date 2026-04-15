package generated

final case class Data1269(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1269 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1269 = copy(value = value * k)
  def addTag(t: String): Data1269 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1269 = copy(meta = meta.updated(k, v))
  def merge(other: Data1269): Data1269 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1269 {
  given Ordering[Data1269] = Ordering.by(_.id)
  def empty: Data1269 = Data1269(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1269 =
    Data1269(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1269] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
