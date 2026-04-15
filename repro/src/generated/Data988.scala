package generated

final case class Data988(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data988 = copy(name = name.toUpperCase)
  def scale(k: Double): Data988 = copy(value = value * k)
  def addTag(t: String): Data988 = copy(tags = t :: tags)
  def put(k: String, v: String): Data988 = copy(meta = meta.updated(k, v))
  def merge(other: Data988): Data988 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data988 {
  given Ordering[Data988] = Ordering.by(_.id)
  def empty: Data988 = Data988(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data988 =
    Data988(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data988] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
