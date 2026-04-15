package generated

final case class Data162(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data162 = copy(name = name.toUpperCase)
  def scale(k: Double): Data162 = copy(value = value * k)
  def addTag(t: String): Data162 = copy(tags = t :: tags)
  def put(k: String, v: String): Data162 = copy(meta = meta.updated(k, v))
  def merge(other: Data162): Data162 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data162 {
  given Ordering[Data162] = Ordering.by(_.id)
  def empty: Data162 = Data162(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data162 =
    Data162(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data162] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
