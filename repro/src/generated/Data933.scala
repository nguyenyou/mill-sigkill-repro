package generated

final case class Data933(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data933 = copy(name = name.toUpperCase)
  def scale(k: Double): Data933 = copy(value = value * k)
  def addTag(t: String): Data933 = copy(tags = t :: tags)
  def put(k: String, v: String): Data933 = copy(meta = meta.updated(k, v))
  def merge(other: Data933): Data933 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data933 {
  given Ordering[Data933] = Ordering.by(_.id)
  def empty: Data933 = Data933(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data933 =
    Data933(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data933] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
