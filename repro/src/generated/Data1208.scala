package generated

final case class Data1208(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1208 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1208 = copy(value = value * k)
  def addTag(t: String): Data1208 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1208 = copy(meta = meta.updated(k, v))
  def merge(other: Data1208): Data1208 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1208 {
  given Ordering[Data1208] = Ordering.by(_.id)
  def empty: Data1208 = Data1208(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1208 =
    Data1208(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1208] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
