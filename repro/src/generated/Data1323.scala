package generated

final case class Data1323(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1323 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1323 = copy(value = value * k)
  def addTag(t: String): Data1323 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1323 = copy(meta = meta.updated(k, v))
  def merge(other: Data1323): Data1323 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1323 {
  given Ordering[Data1323] = Ordering.by(_.id)
  def empty: Data1323 = Data1323(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1323 =
    Data1323(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1323] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
