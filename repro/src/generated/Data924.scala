package generated

final case class Data924(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data924 = copy(name = name.toUpperCase)
  def scale(k: Double): Data924 = copy(value = value * k)
  def addTag(t: String): Data924 = copy(tags = t :: tags)
  def put(k: String, v: String): Data924 = copy(meta = meta.updated(k, v))
  def merge(other: Data924): Data924 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data924 {
  given Ordering[Data924] = Ordering.by(_.id)
  def empty: Data924 = Data924(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data924 =
    Data924(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data924] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
