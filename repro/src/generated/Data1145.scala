package generated

final case class Data1145(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1145 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1145 = copy(value = value * k)
  def addTag(t: String): Data1145 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1145 = copy(meta = meta.updated(k, v))
  def merge(other: Data1145): Data1145 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1145 {
  given Ordering[Data1145] = Ordering.by(_.id)
  def empty: Data1145 = Data1145(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1145 =
    Data1145(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1145] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
