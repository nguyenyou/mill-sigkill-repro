package generated

final case class Data276(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data276 = copy(name = name.toUpperCase)
  def scale(k: Double): Data276 = copy(value = value * k)
  def addTag(t: String): Data276 = copy(tags = t :: tags)
  def put(k: String, v: String): Data276 = copy(meta = meta.updated(k, v))
  def merge(other: Data276): Data276 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data276 {
  given Ordering[Data276] = Ordering.by(_.id)
  def empty: Data276 = Data276(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data276 =
    Data276(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data276] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
