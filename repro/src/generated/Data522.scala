package generated

final case class Data522(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data522 = copy(name = name.toUpperCase)
  def scale(k: Double): Data522 = copy(value = value * k)
  def addTag(t: String): Data522 = copy(tags = t :: tags)
  def put(k: String, v: String): Data522 = copy(meta = meta.updated(k, v))
  def merge(other: Data522): Data522 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data522 {
  given Ordering[Data522] = Ordering.by(_.id)
  def empty: Data522 = Data522(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data522 =
    Data522(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data522] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
