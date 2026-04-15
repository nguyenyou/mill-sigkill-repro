package generated

final case class Data1117(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1117 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1117 = copy(value = value * k)
  def addTag(t: String): Data1117 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1117 = copy(meta = meta.updated(k, v))
  def merge(other: Data1117): Data1117 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1117 {
  given Ordering[Data1117] = Ordering.by(_.id)
  def empty: Data1117 = Data1117(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1117 =
    Data1117(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1117] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
