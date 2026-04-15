package generated

final case class Data181(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data181 = copy(name = name.toUpperCase)
  def scale(k: Double): Data181 = copy(value = value * k)
  def addTag(t: String): Data181 = copy(tags = t :: tags)
  def put(k: String, v: String): Data181 = copy(meta = meta.updated(k, v))
  def merge(other: Data181): Data181 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data181 {
  given Ordering[Data181] = Ordering.by(_.id)
  def empty: Data181 = Data181(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data181 =
    Data181(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data181] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
