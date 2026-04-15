package generated

final case class Data1262(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1262 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1262 = copy(value = value * k)
  def addTag(t: String): Data1262 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1262 = copy(meta = meta.updated(k, v))
  def merge(other: Data1262): Data1262 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1262 {
  given Ordering[Data1262] = Ordering.by(_.id)
  def empty: Data1262 = Data1262(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1262 =
    Data1262(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1262] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
