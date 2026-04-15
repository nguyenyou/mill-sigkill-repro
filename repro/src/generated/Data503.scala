package generated

final case class Data503(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data503 = copy(name = name.toUpperCase)
  def scale(k: Double): Data503 = copy(value = value * k)
  def addTag(t: String): Data503 = copy(tags = t :: tags)
  def put(k: String, v: String): Data503 = copy(meta = meta.updated(k, v))
  def merge(other: Data503): Data503 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data503 {
  given Ordering[Data503] = Ordering.by(_.id)
  def empty: Data503 = Data503(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data503 =
    Data503(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data503] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
