package generated

final case class Data427(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data427 = copy(name = name.toUpperCase)
  def scale(k: Double): Data427 = copy(value = value * k)
  def addTag(t: String): Data427 = copy(tags = t :: tags)
  def put(k: String, v: String): Data427 = copy(meta = meta.updated(k, v))
  def merge(other: Data427): Data427 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data427 {
  given Ordering[Data427] = Ordering.by(_.id)
  def empty: Data427 = Data427(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data427 =
    Data427(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data427] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
