package generated

final case class Data467(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data467 = copy(name = name.toUpperCase)
  def scale(k: Double): Data467 = copy(value = value * k)
  def addTag(t: String): Data467 = copy(tags = t :: tags)
  def put(k: String, v: String): Data467 = copy(meta = meta.updated(k, v))
  def merge(other: Data467): Data467 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data467 {
  given Ordering[Data467] = Ordering.by(_.id)
  def empty: Data467 = Data467(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data467 =
    Data467(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data467] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
