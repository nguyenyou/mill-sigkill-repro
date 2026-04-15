package generated

final case class Data1283(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1283 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1283 = copy(value = value * k)
  def addTag(t: String): Data1283 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1283 = copy(meta = meta.updated(k, v))
  def merge(other: Data1283): Data1283 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1283 {
  given Ordering[Data1283] = Ordering.by(_.id)
  def empty: Data1283 = Data1283(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1283 =
    Data1283(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1283] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
