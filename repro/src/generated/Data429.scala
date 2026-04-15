package generated

final case class Data429(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data429 = copy(name = name.toUpperCase)
  def scale(k: Double): Data429 = copy(value = value * k)
  def addTag(t: String): Data429 = copy(tags = t :: tags)
  def put(k: String, v: String): Data429 = copy(meta = meta.updated(k, v))
  def merge(other: Data429): Data429 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data429 {
  given Ordering[Data429] = Ordering.by(_.id)
  def empty: Data429 = Data429(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data429 =
    Data429(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data429] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
