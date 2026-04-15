package generated

final case class Data1399(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1399 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1399 = copy(value = value * k)
  def addTag(t: String): Data1399 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1399 = copy(meta = meta.updated(k, v))
  def merge(other: Data1399): Data1399 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1399 {
  given Ordering[Data1399] = Ordering.by(_.id)
  def empty: Data1399 = Data1399(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1399 =
    Data1399(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1399] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
